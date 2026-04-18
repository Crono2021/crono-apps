.class public Lorg/drinkless/tdlib/TdApi$LoginUrlInfoOpen;
.super Lorg/drinkless/tdlib/TdApi$LoginUrlInfo;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LoginUrlInfoOpen"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x31e7ea02


# instance fields
.field public skipConfirmation:Z

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28164
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LoginUrlInfo;-><init>()V

    .line 28165
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 28154
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LoginUrlInfo;-><init>()V

    .line 28155
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LoginUrlInfoOpen;->url:Ljava/lang/String;

    .line 28156
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$LoginUrlInfoOpen;->skipConfirmation:Z

    .line 28157
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28161
    const v0, 0x31e7ea02

    return v0
.end method
