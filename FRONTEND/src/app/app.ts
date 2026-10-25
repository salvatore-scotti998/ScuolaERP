import { Component } from '@angular/core';
import { VistaClassiComponent } from './vista-classi/vista-classi'; // ✅ importa il componente

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [VistaClassiComponent], // ✅ aggiungilo qui
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
}
