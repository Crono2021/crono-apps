.class public Lorg/drinkless/tdlib/TdApi$ReportChatPhoto;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportChatPhoto"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x268fed78


# instance fields
.field public chatId:J

.field public fileId:I

.field public reason:Lorg/drinkless/tdlib/TdApi$ReportReason;

.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44910
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44911
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$ReportReason;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "reportReason"    # Lorg/drinkless/tdlib/TdApi$ReportReason;
    .param p5, "str"    # Ljava/lang/String;

    .line 44898
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44899
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReportChatPhoto;->chatId:J

    .line 44900
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ReportChatPhoto;->fileId:I

    .line 44901
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ReportChatPhoto;->reason:Lorg/drinkless/tdlib/TdApi$ReportReason;

    .line 44902
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ReportChatPhoto;->text:Ljava/lang/String;

    .line 44903
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44907
    const v0, -0x268fed78

    return v0
.end method
