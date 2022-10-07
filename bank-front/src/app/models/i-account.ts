
export interface AccountDetails {
  accountId: number;
  balance: number;
  currentPage: number;
  totalPages: number;
  pageSize: number;
  accountOperationsDto: AccountOperation[];
}
export interface AccountOperation {
  id: number;
  createdAt: Date;
  type: string;
  amount: number;
  description: string;

}
export interface IAccount {
  id?: number;
  type?: string;
  balance?: number;
  amount?: number;
 user?: {};

}

