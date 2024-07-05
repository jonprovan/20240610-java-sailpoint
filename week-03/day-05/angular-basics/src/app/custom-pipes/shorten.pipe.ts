import { Pipe, PipeTransform } from '@angular/core';

// this is our custom Pipe to shorten department names
// ng g pipe <pipename> to create a pipe

// uses the annotation @Pipe
// the name value is what you'll use when you implement it on a page
@Pipe({
  name: 'shorten',
  standalone: true
})
export class ShortenPipe implements PipeTransform {

  /**
   * if string is already short enough, just return it
   * 
   * if string is too long, cut it
   *  AND, if I have not given any additional args, use the dots
   *  BUT, if I have given additional args, use the dots AND tack them all on
   * 
   */

  transform(value: string, 
            length: number = 10, 
            dots: boolean = true, 
            ...args: string[]): unknown {
    if (value.length <= length)
      return value;

    let argComposite = '';

    if(dots)
      argComposite += '...';

    if (!args.length)
      return value.slice(0, length) + argComposite;

    for(let arg of args)
      argComposite += arg;

    return value.slice(0, length) + argComposite;
  }

}
