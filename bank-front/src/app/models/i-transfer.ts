export interface IOperation {
  accountId: number;
  amount: number;
  description?: string;
}


export interface IAccountBalance {
  accountId: number;
  balance: number;
  currentPage?: number;
  totalPages?: number;
  pageSize?: number;
}


export interface ITransfer {
  id: number;
  accountSource: number;
  accountDestination: number;
  amount: number;

}
