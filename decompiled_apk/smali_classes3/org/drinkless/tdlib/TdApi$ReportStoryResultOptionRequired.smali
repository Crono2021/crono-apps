.class public Lorg/drinkless/tdlib/TdApi$ReportStoryResultOptionRequired;
.super Lorg/drinkless/tdlib/TdApi$ReportStoryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportStoryResultOptionRequired"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x615537f7


# instance fields
.field public options:[Lorg/drinkless/tdlib/TdApi$ReportOption;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30268
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportStoryResult;-><init>()V

    .line 30269
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$ReportOption;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "reportOptionArr"    # [Lorg/drinkless/tdlib/TdApi$ReportOption;

    .line 30258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportStoryResult;-><init>()V

    .line 30259
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReportStoryResultOptionRequired;->title:Ljava/lang/String;

    .line 30260
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReportStoryResultOptionRequired;->options:[Lorg/drinkless/tdlib/TdApi$ReportOption;

    .line 30261
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30265
    const v0, 0x615537f7

    return v0
.end method
