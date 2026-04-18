.class public Lorg/drinkless/tdlib/TdApi$BusinessChatLinkInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessChatLinkInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x338ccb51


# instance fields
.field public chatId:J

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23324
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23325
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 23314
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23315
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessChatLinkInfo;->chatId:J

    .line 23316
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$BusinessChatLinkInfo;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 23317
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23321
    const v0, -0x338ccb51    # -6.375494E7f

    return v0
.end method
