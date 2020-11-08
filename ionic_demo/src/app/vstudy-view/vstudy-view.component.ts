
import { Component, Input, OnInit, ViewChild, ElementRef, AfterViewInit } from '@angular/core';
import { NavController, ModalController } from '@ionic/angular';
import { VstudentinfoService } from '../provider/vstudentinfo.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-vstudy-view',
  templateUrl: './vstudy-view.component.html',
  styleUrls: ['./vstudy-view.component.scss'],
})
export class VstudyViewComponent implements OnInit, AfterViewInit {
  @ViewChild('video1') myVid: ElementRef;
  @ViewChild('bbb') vName: ElementRef;
  //@ViewChild('beginTime') bgTime: ElementRef;
  //@ViewChild('lastTime') lsTime: ElementRef;
  //@ViewChild('text_progress') elem: ElementRef;


  videoUrl: string;
  videoName: string;
  tabs: string = "details";
  isVisble: boolean = true;
  //myVid=document.getElementById("video1"); 
  _endTime: any;
  _startTime: any;
  timer;
  fileUrl = "http://192.168.0.109:21021/browse/UploadFile//aaa//";
  vstudyDetailList: any[];
  attId: number;
  folderName: string;

  // tslint:disable-next-line:max-line-length
  constructor(public navController: NavController, public vstudentService: VstudentinfoService, public activatedRoute: ActivatedRoute, public router: Router) {

  }


  ngOnInit() {

    this.videoUrl = this.activatedRoute.snapshot.params['videoUrl'];
    this.videoName = this.activatedRoute.snapshot.params['videoName'];
    this.attId = this.activatedRoute.snapshot.params['attId'];
    this.getVstudyListByAttId();
    this.folderName = this.getFolderName(this.videoName);


  }
  ngAfterViewInit(): void {
    const arrCookie = document.cookie.split(';');
    // 遍历cookie数组，处理每个cookie对
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < arrCookie.length; i++) {
      const arr = arrCookie[i].split('=');
      // 找到名称为userId的cookie，并返回它的值
      if ('startTime' === arr[0]) {
        this._startTime = arr[1];
        break;
      }
    }

    this.playMedia(this._startTime, 200);
    // this.myVid.nativeElement.addEventListener("timeupdate",this.timeupdate());
    setInterval(this.frame, 10);

  }



  goback1(): void {
    this.navController.back();
  }

  doPressLeft(): void {
    alert("Hi 我在向左滑動");
    this.navController.back();
  }
  doPressRight(): void {
    alert("Hi 我在向右滑動");
    //this.router.navigate(['vsinfo',item],{ queryParams: { 'item': item }});
    this.router.navigate(['tabs/tab1']);
  }
  doPressUp(): void {
    alert("Hi 我在向上滑動");
    this.isVisble = false;
    this.tabs = "comments";
  }
  doPressDown(): void {
    alert("Hi 我在向下滑動");
    this.isVisble = true;
    this.tabs = "details";
  }

  timeupdate() {
    //因为当前的格式是带毫秒的float类型的如：12.231233，所以把他转成String了便于后面分割取秒  
    var time = this.myVid.nativeElement.currentTime + "";

    var ts = time.substring(0, time.indexOf("."));
    if (ts == this._endTime) {
      this.myVid.nativeElement.pause();
    }

  }

  //视频播放  
  playMedia(startTime, endTime) {
    //设置结束时间  
    this._endTime = endTime;

    this.myVid.nativeElement.src = this.activatedRoute.snapshot.params['videoUrl'];
    this.myVid.nativeElement.controls = true;
    setTimeout(() => {
      this.setCurrentTime(startTime);

    }, 200);
  }


  //设置视频开始播放事件  
  setCurrentTime(startTime) {
    this.myVid.nativeElement.currentTime = startTime;
    //this.myVid.nativeElement.play();
    this.myVid.nativeElement.pause();
  }

  async getVstudyListByAttId() {

    (await (this.vstudentService.getVStudyDetailList(this.attId))).subscribe((response: any) => this.vstudyDetailList = response.body.result);

  }

  public getFolderName(fileName: string): string {
    let folderName: string;
    folderName = fileName.substring(0, fileName.indexOf('.')) + "\\";
    return folderName;
  }

  frame(): void {
    // 使用duration获取视频总时长,使用toFixed保留两位小数
    const bgTime = document.getElementById('beginTime');
    const lsTime = document.getElementById('lastTime');
    const elem = document.getElementById('text_progress');
    const video1 = document.getElementById('video1');

    // 使用currentTime获取视频当前播放位置
    bgTime.innerHTML = video1.currentTime.toFixed(2) + 's';
    // 获取当前位置占总视频百分比并显示
    const bili = (video1.currentTime.toFixed(2) / video1.duration.toFixed(2)) * 100;
    elem.innerHTML = bili.toFixed(0) + '%';

    document.cookie = 'startTime=' + video1.currentTime;

  }

}

