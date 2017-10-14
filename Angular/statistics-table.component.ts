import { Component } from '@angular/core';
import {IMyDateRangeModel, IMyDrpOptions} from 'mydaterangepicker';
import {StatisticService} from "../../../services/services/statistic.service";
import {Statistic} from "../../../services/entities/Statistic";
import {FilialProjectService} from "../../../services/services/filialProject.service";
import {FilialProject} from "../../../services/entities/FilialProject";

@Component({
  selector: 'app-statisticsTable',
  templateUrl: './statistics-table.component.html',
  styleUrls: ['./statistics-table.component.css']
})

export class StatisticsTableComponent {
  page: number;
  size:number;
  project:string;
  stream:string;
  dateFrom:string;
  dateTo:string;

  statisticList:Statistic[];
  projectList:FilialProject[];
  selectedProject:FilialProject;
  response: any;


  public model: Object = {beginDate: {year: 2017, month: 8, day: 24},
    endDate: {year: 2017, month: 8, day: 31}};

  constructor(private statisticService:StatisticService,
              private filialProjectService:FilialProjectService){
    this.page = 0;
    this.size= 10;
    this.project="All";
    this.stream="All";
  }

  ngOnInit() {
    this.getStatistic();
    this.getFilialProjects();
  }

  getFilialProjects() {
    this.filialProjectService.getAllFilialProjects()
      .subscribe(pr => {
        this.projectList = pr;
        this.selectedProject = this.projectList[0];
      });
  }

  getStatistic(){
    this.statisticService.
    getStatistic(this.page, this.size, this.project, this.stream, this.dateFrom, this.dateTo).subscribe(st =>{
      this.statisticList = st;
      console.log(this.statisticList);
    });
  }

  getDate(time:number){
   return new Date(time);
  }

  public  myDateRangePickerOptions: IMyDrpOptions = {
    dateFormat: 'dd.mm.yyyy',
    inline: false,
    showClearDateRangeBtn: false,
    width: '205px',

  };

}

