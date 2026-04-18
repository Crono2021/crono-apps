.class public Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeMissedCall;
.super Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthenticationCodeTypeMissedCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x29bb0a87


# instance fields
.field public length:I

.field public phoneNumberPrefix:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 23005
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 22994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeType;-><init>()V

    .line 22995
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeMissedCall;->phoneNumberPrefix:Ljava/lang/String;

    .line 22996
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AuthenticationCodeTypeMissedCall;->length:I

    .line 22997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23001
    const v0, 0x29bb0a87

    return v0
.end method
