import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SectionFeaturesComponent } from './section-features/section-features.component';
import { SectionTwoComponent } from './section-two/section-two.component';
import { SectionStepsComponent } from './section-steps/section-steps.component';
import { SectionDataComponent } from './section-data/section-data.component';
import { SectionTestimonialsComponent } from './section-testimonials/section-testimonials.component';
import { SectionPlansComponent } from './section-plans/section-plans.component';
import { SectionNewletterformComponent } from './section-newletterform/section-newletterform.component';
import { FooterComponent } from './footer/footer.component';
import { NavigationComponent } from './navigation/navigation.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SectionFeaturesComponent,
    SectionTwoComponent,
    SectionStepsComponent,
    SectionDataComponent,
    SectionTestimonialsComponent,
    SectionPlansComponent,
    SectionNewletterformComponent,
    FooterComponent,
    NavigationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
