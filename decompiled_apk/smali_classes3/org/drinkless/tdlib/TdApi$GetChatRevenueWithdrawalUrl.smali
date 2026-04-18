.class public Lorg/drinkless/tdlib/TdApi$GetChatRevenueWithdrawalUrl;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatRevenueWithdrawalUrl"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1e320720


# instance fields
.field public chatId:J

.field public password:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25904
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25905
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 25894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25895
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatRevenueWithdrawalUrl;->chatId:J

    .line 25896
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatRevenueWithdrawalUrl;->password:Ljava/lang/String;

    .line 25897
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25901
    const v0, 0x1e320720

    return v0
.end method
