import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { AdminService } from '../../admin-services/admin.service';

@Component({
  selector: 'app-update-room',
  templateUrl: './update-room.component.html',
  styleUrl: './update-room.component.css'
})
export class UpdateRoomComponent {

  upateRoomForm: FormGroup;
  
    constructor(private fb: FormBuilder,
      private message: NzMessageService,
      private router: Router,
      private adminService: AdminService,
      private activatedroute: ActivatedRoute,
      id = this.activatedroute.snapshot.params['id'],
    ){
      this.upateRoomForm = this.fb.group({
        name: ['', Validators.required],
        type: ['', Validators.required],
        price: ['', Validators.required]
      })
    }

    submitForm(){
      
    }
}
