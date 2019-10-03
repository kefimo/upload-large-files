import { Component, Directive, OnInit, NgZone, Input } from '@angular/core';
import { FileSelectDirective, FileDropDirective, FileUploader } from 'ng2-file-upload/ng2-file-upload';
import { Http } from "@angular/http/src";
import { FileUploaderOptions } from "ng2-file-upload";

import { Cloudinary } from '@cloudinary/angular-4.x';
//const URL = '/api/';
const URL = 'http://localhost:8091/api/';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  
})
// class FileSelectDirective
export class AppComponent implements OnInit{
    uploadedFiles: Array < File > ;
    constructor(private http: Http) {

    }

    ngOnInit(): void {
     
    }
    
    fileChange(element) {
        this.uploadedFiles = element.target.files;
    }
    
    upload() {
        let formData = new FormData();
        for (var i = 0; i < this.uploadedFiles.length; i++) {
            formData.append("uploads[]", this.uploadedFiles[i], this.uploadedFiles[i].name);
        }
        this.http.post('/uploadServices/uploadFile', formData)
        .subscribe((response) => {
             console.log('response received is ', response);
        })
    }
}
