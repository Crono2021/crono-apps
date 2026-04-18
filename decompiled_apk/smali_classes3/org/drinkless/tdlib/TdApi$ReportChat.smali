.class public Lorg/drinkless/tdlib/TdApi$ReportChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReportChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ReportChatResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3f170c32


# instance fields
.field public chatId:J

.field public messageIds:[J

.field public optionId:[B

.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44886
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44887
    return-void
.end method

.method public constructor <init>(J[B[JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "bArr"    # [B
    .param p4, "jArr"    # [J
    .param p5, "str"    # Ljava/lang/String;

    .line 44874
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44875
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReportChat;->chatId:J

    .line 44876
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ReportChat;->optionId:[B

    .line 44877
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ReportChat;->messageIds:[J

    .line 44878
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ReportChat;->text:Ljava/lang/String;

    .line 44879
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44883
    const v0, 0x3f170c32

    return v0
.end method
