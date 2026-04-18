.class public Lorg/drinkless/tdlib/TdApi$GetBankCardInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBankCardInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BankCardInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4e1ce250


# instance fields
.field public bankCardNumber:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12066
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12067
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 12057
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12058
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetBankCardInfo;->bankCardNumber:Ljava/lang/String;

    .line 12059
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12063
    const v0, -0x4e1ce250

    return v0
.end method
