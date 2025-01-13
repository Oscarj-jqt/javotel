import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth/auth.service';
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {


  registerForm!: FormGroup;

  // Inject FormBuilder to simplify form creation
  constructor(private fb: FormBuilder,
            private authService: AuthService,
            private message: NzMessageService,
            private router: Router){}

  ngOnInit(){
    // Initialize the reactive form with form controls and validators
    this.registerForm = this.fb.group({
      email: [null, [Validators.email, Validators.required]],
      password: [null, Validators.required],
      name: [null, Validators.required]
    })
  }

  submitForm(){
    this.authService.register(this.registerForm.value).subscribe(res=> {
      if(res.id != null) {
        this.message.success("Inscription réussie", { nzDuration: 5000 });
        this.router.navigateByUrl("/");
      } else {
        this.message.error(`${res.message}`, { nzDuration: 5000 })
      }
    })
  }

}
