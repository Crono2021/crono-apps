.class public Lorg/drinkless/tdlib/TdApi$ChatTypeBasicGroup;
.super Lorg/drinkless/tdlib/TdApi$ChatType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatTypeBasicGroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3a0c4c5c


# instance fields
.field public basicGroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10446
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatType;-><init>()V

    .line 10447
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 10437
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatType;-><init>()V

    .line 10438
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatTypeBasicGroup;->basicGroupId:J

    .line 10439
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10443
    const v0, 0x3a0c4c5c

    return v0
.end method
