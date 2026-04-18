.class public Lorg/drinkless/tdlib/TdApi$SetPassword;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetPassword"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PasswordState;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4724b923


# instance fields
.field public newHint:Ljava/lang/String;

.field public newPassword:Ljava/lang/String;

.field public newRecoveryEmailAddress:Ljava/lang/String;

.field public oldPassword:Ljava/lang/String;

.field public setRecoveryEmailAddress:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48710
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48711
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "z8"    # Z
    .param p5, "str4"    # Ljava/lang/String;

    .line 48697
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48698
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetPassword;->oldPassword:Ljava/lang/String;

    .line 48699
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetPassword;->newPassword:Ljava/lang/String;

    .line 48700
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetPassword;->newHint:Ljava/lang/String;

    .line 48701
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$SetPassword;->setRecoveryEmailAddress:Z

    .line 48702
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SetPassword;->newRecoveryEmailAddress:Ljava/lang/String;

    .line 48703
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48707
    const v0, -0x4724b923

    return v0
.end method
