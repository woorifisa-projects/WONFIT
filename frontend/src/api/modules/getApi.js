import api from "@/api/index.js";

export const getApi = async (param) => {
  const { data } = await api({
    method: "get",
    url: param.url,
    data: param.data,
  },
    { withCredentials: true });
  return data;
};
