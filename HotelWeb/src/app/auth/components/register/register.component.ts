import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {


  registerForm!: FormGroup;

  // Inject FormBuilder to simplify form creation
  constructor(private fb: FormBuilder,){}

  ngOnInit(){
    // Initialize the reactive form with form controls and validators
    this.registerForm = this.fb.group({
      email: [null, [Validators.email, Validators.required]],
      password: [null, Validators.required],
      name: [null, Validators.required]
    })
  }

}
