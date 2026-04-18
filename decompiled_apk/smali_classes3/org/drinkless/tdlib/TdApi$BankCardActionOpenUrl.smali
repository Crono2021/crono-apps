.class public Lorg/drinkless/tdlib/TdApi$BankCardActionOpenUrl;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BankCardActionOpenUrl"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xbb5a77b


# instance fields
.field public text:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23124
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23125
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 23114
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23115
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BankCardActionOpenUrl;->text:Ljava/lang/String;

    .line 23116
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BankCardActionOpenUrl;->url:Ljava/lang/String;

    .line 23117
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23121
    const v0, -0xbb5a77b

    return v0
.end method
