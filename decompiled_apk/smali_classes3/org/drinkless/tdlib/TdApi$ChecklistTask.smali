.class public Lorg/drinkless/tdlib/TdApi$ChecklistTask;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChecklistTask"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2e12ee00


# instance fields
.field public completedByUserId:J

.field public completionDate:I

.field public id:I

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42895
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$FormattedText;JI)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p3, "j5"    # J
    .param p5, "i10"    # I

    .line 42882
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42883
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChecklistTask;->id:I

    .line 42884
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChecklistTask;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 42885
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ChecklistTask;->completedByUserId:J

    .line 42886
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ChecklistTask;->completionDate:I

    .line 42887
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42891
    const v0, 0x2e12ee00

    return v0
.end method
