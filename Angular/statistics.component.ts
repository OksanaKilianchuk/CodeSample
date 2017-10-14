import { Component } from "@angular/core";
import {AppSettings} from "../../services/services/appSettings";
import {Router} from "@angular/router";
import {StatisticService} from "../../services/services/statistic.service";

@Component({
  selector: 'app-statistics',
  template: `<div class="statistics">
                <h2 class="component-title">Статистика:</h2>
                <app-statisticsHeader></app-statisticsHeader>
                <app-statisticsTable></app-statisticsTable>
            </div>`,
  styleUrls: ['./statistics.component.css']
})

export class StatisticsComponent {
  constructor(private appSettings:AppSettings,
              private router: Router){
    if(!appSettings.isAuthorized()){
      this.router.navigate(['/']);
    }
  }
}
