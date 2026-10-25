import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common'; // ✅ aggiungi questo
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vista-classi',
  standalone: true, // ✅ importante: il componente è standalone
  imports: [CommonModule, FormsModule], // ✅ aggiungi qui il modulo
  templateUrl: './vista-classi.html',
  styleUrls: ['./vista-classi.css']
})

export class VistaClassiComponent implements OnInit {
  dati: any[] = [];
  datiFiltrati: any[] = [];
  filtri: any = {}; // Oggetto dinamico per i filtri per colonna

  showIdFilter = false;
  showNomeFilter = false;
  showCognomeFilter = false;
  showAnnoFilter = false;
  showClasseFilter = false;
  showSezioneFilter = false;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<any[]>('http://localhost:8080/api/classi-alunni')
      .subscribe({
        next: (response) => {
          this.dati = response;
          this.datiFiltrati = response;
        },
        error: (err) => console.error('Errore nel recupero dati', err)
      });
  }

  // ✅ Funzione di filtraggio generale
  filtra(): void {
    this.datiFiltrati = this.dati.filter(riga =>
      Object.keys(this.filtri).every(colonna => {
        const valore = (this.filtri[colonna] || '').toString().toLowerCase();
        return !valore || riga[colonna]?.toString().toLowerCase().includes(valore);
      })
    );
  }
}

