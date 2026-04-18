.class public Lorg/drinkless/tdlib/TdApi$ReportChatResultOptionRequired;
.super Lorg/drinkless/tdlib/TdApi$ReportChatResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportChatResultOptionRequired"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3488b9b5


# instance fields
.field public options:[Lorg/drinkless/tdlib/TdApi$ReportOption;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30168
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportChatResult;-><init>()V

    .line 30169
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Lorg/drinkless/tdlib/TdApi$ReportOption;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "reportOptionArr"    # [Lorg/drinkless/tdlib/TdApi$ReportOption;

    .line 30158
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReportChatResult;-><init>()V

    .line 30159
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReportChatResultOptionRequired;->title:Ljava/lang/String;

    .line 30160
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReportChatResultOptionRequired;->options:[Lorg/drinkless/tdlib/TdApi$ReportOption;

    .line 30161
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30165
    const v0, -0x3488b9b5    # -1.6205387E7f

    return v0
.end method
