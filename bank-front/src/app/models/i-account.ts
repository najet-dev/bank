
export interface AccountDetails {
  accountId: number;
  balance: number;
  User: {
    id: number;
  };
  accountOperationsDto: AccountOperationsDTOModel;
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
export interface IAccounts{
  id: number;
  type: String;
  createdAt?: Date;
  balance?: number;
}
export interface IAccountBalance{
  id: number;
  createdAt?: Date;

}
