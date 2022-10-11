
export interface AccountDetails {
  accountId: number;
  balance: number;
  currentPage: number;
  totalPages: number;
  pageSize: number;
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
  createdAt: Date;
  type: string;
  amount: number;
  description: string;


}


