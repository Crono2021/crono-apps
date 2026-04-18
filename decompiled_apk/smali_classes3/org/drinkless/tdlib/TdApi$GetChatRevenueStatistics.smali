.class public Lorg/drinkless/tdlib/TdApi$GetChatRevenueStatistics;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatRevenueStatistics"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatRevenueStatistics;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x29d79b3c


# instance fields
.field public chatId:J

.field public isDark:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25885
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 25874
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25875
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatRevenueStatistics;->chatId:J

    .line 25876
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatRevenueStatistics;->isDark:Z

    .line 25877
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25881
    const v0, 0x29d79b3c

    return v0
.end method
