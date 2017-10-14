import { Component } from '@angular/core';
import {AppSettings} from "../../../services/services/appSettings";
import {StatisticService} from "../../../services/services/statistic.service";
import {Router} from "@angular/router";
import {GeneralStatistic} from "../../../services/entities/GeneralStatistic";


@Component({
  selector: 'app-statisticsHeader',
  templateUrl: './statistics-header.component.html',
  styleUrls: ['./statistics-header.component.css']
})

export class StatisticsHeaderComponent {
  generalStatistic:GeneralStatistic;

  constructor(private statisticService:StatisticService){
  }

  ngOnInit() {
    this.statisticService.
    getGeneralStatistic().subscribe(st =>{
      this.generalStatistic = st;
      console.log(this.generalStatistic);
    });
  }

}
