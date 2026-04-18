.class public Lorg/drinkless/tdlib/TdApi$PhoneNumberCodeTypeConfirmOwnership;
.super Lorg/drinkless/tdlib/TdApi$PhoneNumberCodeType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PhoneNumberCodeTypeConfirmOwnership"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1ceeb018


# instance fields
.field public hash:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PhoneNumberCodeType;-><init>()V

    .line 17755
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 17745
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PhoneNumberCodeType;-><init>()V

    .line 17746
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PhoneNumberCodeTypeConfirmOwnership;->hash:Ljava/lang/String;

    .line 17747
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17751
    const v0, -0x1ceeb018

    return v0
.end method
