.class public Lorg/drinkless/tdlib/TdApi$ChatEventIsAllHistoryAvailableToggled;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventIsAllHistoryAvailableToggled"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5f4fc3eb


# instance fields
.field public isAllHistoryAvailable:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9960
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9961
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 9951
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 9952
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventIsAllHistoryAvailableToggled;->isAllHistoryAvailable:Z

    .line 9953
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9957
    const v0, -0x5f4fc3eb

    return v0
.end method
