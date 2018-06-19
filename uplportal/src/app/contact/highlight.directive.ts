import { Directive, ElementRef } from '@angular/core';
@Directive({ selector: '[highlight], input' })
/** Highlight the attached element or an InputElement in blue */
export class HighlightDirective {
  constructor(el: ElementRef) {
    el.nativeElement.style.backgroundColor = 'powderblue';
    console.log(
      `* Contact highlight called for ${el.nativeElement.tagName}`);
  }
}
