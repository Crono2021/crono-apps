.class public Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticationCodeInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3347d448


# instance fields
.field public nextType:Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;

.field public phoneNumber:Ljava/lang/String;

.field public timeout:I

.field public type:Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42342
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42343
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "authenticationCodeType"    # Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
    .param p3, "authenticationCodeType2"    # Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
    .param p4, "i9"    # I

    .line 42330
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42331
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;->phoneNumber:Ljava/lang/String;

    .line 42332
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;->type:Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;

    .line 42333
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;->nextType:Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;

    .line 42334
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;->timeout:I

    .line 42335
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42339
    const v0, -0x3347d448    # -9.655853E7f

    return v0
.end method
