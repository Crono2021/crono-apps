.class public Lorg/drinkless/tdlib/TdApi$ChatBoostLinkInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatBoostLinkInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x23edc77c


# instance fields
.field public chatId:J

.field public isPublic:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23624
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23625
    return-void
.end method

.method public constructor <init>(ZJ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "j5"    # J

    .line 23614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23615
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLinkInfo;->isPublic:Z

    .line 23616
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ChatBoostLinkInfo;->chatId:J

    .line 23617
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23621
    const v0, -0x23edc77c

    return v0
.end method
