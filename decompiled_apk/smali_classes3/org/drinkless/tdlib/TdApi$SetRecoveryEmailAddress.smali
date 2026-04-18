.class public Lorg/drinkless/tdlib/TdApi$SetRecoveryEmailAddress;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetRecoveryEmailAddress"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PasswordState;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x76206c61


# instance fields
.field public newRecoveryEmailAddress:Ljava/lang/String;

.field public password:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31848
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31849
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 31838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31839
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetRecoveryEmailAddress;->password:Ljava/lang/String;

    .line 31840
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetRecoveryEmailAddress;->newRecoveryEmailAddress:Ljava/lang/String;

    .line 31841
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31845
    const v0, -0x76206c61

    return v0
.end method
