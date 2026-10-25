import { ComponentFixture, TestBed } from '@angular/core/testing';
import { VistaClassiComponent } from './vista-classi'; // ✅ giusto
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';

describe('VistaClassiComponent', () => {
  let component: VistaClassiComponent;
  let fixture: ComponentFixture<VistaClassiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VistaClassiComponent],
      providers: [
        provideHttpClient(),
        provideHttpClientTesting(),
      ],
    }).compileComponents();

    fixture = TestBed.createComponent(VistaClassiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
