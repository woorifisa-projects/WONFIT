import api from "@/api/index.js";

export const postApi = async (param) => {
  const { data } = await api({
    method: "post",
    url: param.url,
    data: param.data,
  },
    { withCredentials: true });
  return data;
};
