.class public Lorg/drinkless/tdlib/TdApi$ChatEventMessageDeleted;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMessageDeleted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x37bfcd73


# instance fields
.field public canReportAntiSpamFalsePositive:Z

.field public message:Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23965
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;Z)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p2, "z8"    # Z

    .line 23954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23955
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMessageDeleted;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 23956
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventMessageDeleted;->canReportAntiSpamFalsePositive:Z

    .line 23957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23961
    const v0, 0x37bfcd73

    return v0
.end method
