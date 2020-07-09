import {Routes} from '@angular/router';
import {TableListComponent} from '../../table-list/table-list.component';
import {TableListResolver} from '../../table-list/table-list.resolver';

export const AdminLayoutRoutes: Routes = [
  {
    path: 'products', component: TableListComponent, data: {
      'url': 'http://localhost:8080/api/product',
      'keys': ['id', 'name', 'price']
    }, resolve: {
      list: TableListResolver
    }
  },
];
