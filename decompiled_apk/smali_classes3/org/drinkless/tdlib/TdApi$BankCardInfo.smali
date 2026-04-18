.class public Lorg/drinkless/tdlib/TdApi$BankCardInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BankCardInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7e297b32


# instance fields
.field public actions:[Lorg/drinkless/tdlib/TdApi$BankCardActionOpenUrl;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23144
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23145
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$BankCardActionOpenUrl;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "bankCardActionOpenUrlArr"    # [Lorg/drinkless/tdlib/TdApi$BankCardActionOpenUrl;

    .line 23134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23135
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BankCardInfo;->title:Ljava/lang/String;

    .line 23136
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BankCardInfo;->actions:[Lorg/drinkless/tdlib/TdApi$BankCardActionOpenUrl;

    .line 23137
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23141
    const v0, -0x7e297b32

    return v0
.end method
