.class public Lorg/drinkless/tdlib/TdApi$ChatTypeSupergroup;
.super Lorg/drinkless/tdlib/TdApi$ChatType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatTypeSupergroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x57c5a596


# instance fields
.field public isChannel:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24484
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatType;-><init>()V

    .line 24485
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 24474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatType;-><init>()V

    .line 24475
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatTypeSupergroup;->supergroupId:J

    .line 24476
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ChatTypeSupergroup;->isChannel:Z

    .line 24477
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24481
    const v0, -0x57c5a596

    return v0
.end method
