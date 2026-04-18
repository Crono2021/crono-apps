.class public Lorg/drinkless/tdlib/TdApi$FoundMessages;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1f9440c8


# instance fields
.field public messages:[Lorg/drinkless/tdlib/TdApi$Message;

.field public nextOffset:Ljava/lang/String;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37048
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37049
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$Message;Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageArr"    # [Lorg/drinkless/tdlib/TdApi$Message;
    .param p3, "str"    # Ljava/lang/String;

    .line 37037
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37038
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$FoundMessages;->totalCount:I

    .line 37039
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FoundMessages;->messages:[Lorg/drinkless/tdlib/TdApi$Message;

    .line 37040
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$FoundMessages;->nextOffset:Ljava/lang/String;

    .line 37041
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37045
    const v0, -0x1f9440c8

    return v0
.end method
