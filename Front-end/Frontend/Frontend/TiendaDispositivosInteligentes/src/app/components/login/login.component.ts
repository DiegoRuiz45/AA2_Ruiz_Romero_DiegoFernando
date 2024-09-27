import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  constructor(private router: Router) {}


onSubmit() {
    console.log('Username: ', this.username);
    console.log('Password: ', this.password);
    this.validarLogin();
}


  validarLogin(){
    if(this.username === "admin" && this.password === "admin"){
      //redoireccionar a dashboard
      this.router.navigate(['/dashboard']);
      Swal.fire({
        icon: "success",
        title: "Bienvenido...",
        footer: '<h5>Bienvenidos a la tienda de objetos inteligentes</h5>'
      });
    }else{
      //recargar el formulario y decir un error
      
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "No se encontro el usuario",
        footer: '<a href="#">¿Por qué tengo este problema??</a>'
      });
        this.router.navigate(['/login']);
    }
  }


}
