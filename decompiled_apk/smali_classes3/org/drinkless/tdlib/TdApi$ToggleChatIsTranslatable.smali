.class public Lorg/drinkless/tdlib/TdApi$ToggleChatIsTranslatable;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleChatIsTranslatable"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6c063421


# instance fields
.field public chatId:J

.field public isTranslatable:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33148
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33149
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33138
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33139
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatIsTranslatable;->chatId:J

    .line 33140
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatIsTranslatable;->isTranslatable:Z

    .line 33141
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33145
    const v0, -0x6c063421

    return v0
.end method
