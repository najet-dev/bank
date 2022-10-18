
export interface AccountDetails {
  accountId: number;
  balance: number;
  accountOperationsDto: AccountOperationsDTOModel;
}

export interface IAccountByIdUser {
  id: number;
  userName: string;
  name: string;
  type: string;
  balance: number;
}


export interface AccountOperationsDTOModel {
  content : AccountOperation[];
  empty : boolean;
  first : boolean;
  last : boolean;
  number : Number;
  pageNumber: number;
  pageSize: number;
  numberOfElements : Number;
  pageable;
  size : Number;
  sort;
  totalElements:Number;
  totalPages: Number;
}

export interface AccountOperation {
  id: number;
  createdAt?: Date;
  type: string;
  amount: number;
  description: string;

}


