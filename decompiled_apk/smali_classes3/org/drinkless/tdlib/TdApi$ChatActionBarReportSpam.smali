.class public Lorg/drinkless/tdlib/TdApi$ChatActionBarReportSpam;
.super Lorg/drinkless/tdlib/TdApi$ChatActionBar;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActionBarReportSpam"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4e3f19e6


# instance fields
.field public canUnarchive:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9582
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatActionBar;-><init>()V

    .line 9583
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 9573
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatActionBar;-><init>()V

    .line 9574
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ChatActionBarReportSpam;->canUnarchive:Z

    .line 9575
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9579
    const v0, -0x4e3f19e6

    return v0
.end method
