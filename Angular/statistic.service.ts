import {Injectable, Input} from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {AppSettings} from './appSettings';
import 'rxjs/add/operator/map';
import {HttpClient} from "./authorization/http-client";
import {Statistic} from "../entities/Statistic";
import {GeneralStatistic} from "../entities/GeneralStatistic";

@Injectable()
export class StatisticService {
  private baseUrl: string = AppSettings.API_ENDPOINT+'/statistic';
  http:HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  getGeneralStatistic(): Observable<GeneralStatistic> {
    let statistic$ = this.http
      .get(`${this.baseUrl}/general/`)
      .map(response => response.json() as GeneralStatistic);
    return statistic$;
  }

  getStatistic(page, size, projectId, affLinkUrl, dateFrom, dateTo): Observable<Statistic[]> {
    let statistic$ = this.http
      .get(`${this.baseUrl}`+"/"+page+"/"+size+"/"+projectId+"/"+affLinkUrl+"/"+dateFrom+"/"+dateTo)
      .map(response => response.json() as Statistic[]);
    return statistic$;
  }

}


