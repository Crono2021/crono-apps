.class public Lorg/drinkless/tdlib/TdApi$ReportSponsoredResultOptionRequired;
.super Lorg/drinkless/tdlib/TdApi$ReportSponsoredResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportSponsoredResultOptionRequired"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x62267456


# instance fields
.field public options:[Lorg/drinkless/tdlib/TdApi$ReportOption;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30248
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportSponsoredResult;-><init>()V

    .line 30249
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$ReportOption;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "reportOptionArr"    # [Lorg/drinkless/tdlib/TdApi$ReportOption;

    .line 30238
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportSponsoredResult;-><init>()V

    .line 30239
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReportSponsoredResultOptionRequired;->title:Ljava/lang/String;

    .line 30240
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReportSponsoredResultOptionRequired;->options:[Lorg/drinkless/tdlib/TdApi$ReportOption;

    .line 30241
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30245
    const v0, -0x62267456

    return v0
.end method
