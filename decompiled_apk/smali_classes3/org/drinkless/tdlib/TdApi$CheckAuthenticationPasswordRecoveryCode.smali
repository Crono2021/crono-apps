.class public Lorg/drinkless/tdlib/TdApi$CheckAuthenticationPasswordRecoveryCode;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CheckAuthenticationPasswordRecoveryCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x23f5c41b


# instance fields
.field public recoveryCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10555
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 10545
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10546
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CheckAuthenticationPasswordRecoveryCode;->recoveryCode:Ljava/lang/String;

    .line 10547
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10551
    const v0, -0x23f5c41b

    return v0
.end method
