.class public Lorg/drinkless/tdlib/TdApi$ShareUsersWithBot;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ShareUsersWithBot"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5dda9dcd


# instance fields
.field public buttonId:I

.field public chatId:J

.field public messageId:J

.field public onlyCheck:Z

.field public sharedUserIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48762
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48763
    return-void
.end method

.method public constructor <init>(JJI[JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "jArr"    # [J
    .param p7, "z8"    # Z

    .line 48749
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48750
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ShareUsersWithBot;->chatId:J

    .line 48751
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ShareUsersWithBot;->messageId:J

    .line 48752
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ShareUsersWithBot;->buttonId:I

    .line 48753
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$ShareUsersWithBot;->sharedUserIds:[J

    .line 48754
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$ShareUsersWithBot;->onlyCheck:Z

    .line 48755
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48759
    const v0, -0x5dda9dcd

    return v0
.end method
