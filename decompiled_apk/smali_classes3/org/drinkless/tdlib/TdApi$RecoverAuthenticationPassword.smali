.class public Lorg/drinkless/tdlib/TdApi$RecoverAuthenticationPassword;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RecoverAuthenticationPassword"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7ceeadd


# instance fields
.field public newHint:Ljava/lang/String;

.field public newPassword:Ljava/lang/String;

.field public recoveryCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39382
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39383
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;

    .line 39371
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39372
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RecoverAuthenticationPassword;->recoveryCode:Ljava/lang/String;

    .line 39373
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RecoverAuthenticationPassword;->newPassword:Ljava/lang/String;

    .line 39374
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$RecoverAuthenticationPassword;->newHint:Ljava/lang/String;

    .line 39375
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39379
    const v0, -0x7ceeadd

    return v0
.end method
