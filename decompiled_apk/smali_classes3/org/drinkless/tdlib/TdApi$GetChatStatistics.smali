.class public Lorg/drinkless/tdlib/TdApi$GetChatStatistics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatStatistics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatStatistics;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x137e8198


# instance fields
.field public chatId:J

.field public isDark:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25945
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 25934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25935
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatStatistics;->chatId:J

    .line 25936
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatStatistics;->isDark:Z

    .line 25937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25941
    const v0, 0x137e8198

    return v0
.end method
