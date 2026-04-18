.class public abstract Lcom/cineflix/android/TelegramEngine$AuthState;
.super Ljava/lang/Object;
.source "TelegramEngine.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/cineflix/android/TelegramEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "AuthState"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/cineflix/android/TelegramEngine$AuthState$Error;,
        Lcom/cineflix/android/TelegramEngine$AuthState$LoggingOut;,
        Lcom/cineflix/android/TelegramEngine$AuthState$Ready;,
        Lcom/cineflix/android/TelegramEngine$AuthState$Unknown;,
        Lcom/cineflix/android/TelegramEngine$AuthState$WaitCode;,
        Lcom/cineflix/android/TelegramEngine$AuthState$WaitPassword;,
        Lcom/cineflix/android/TelegramEngine$AuthState$WaitPhone;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\u0008\tB\u0007\u0008\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\u000c\r\u000e\u000f\u0010\u00a8\u0006\u0011"
    }
    d2 = {
        "Lcom/cineflix/android/TelegramEngine$AuthState;",
        "",
        "()V",
        "Error",
        "LoggingOut",
        "Ready",
        "Unknown",
        "WaitCode",
        "WaitPassword",
        "WaitPhone",
        "Lcom/cineflix/android/TelegramEngine$AuthState$Error;",
        "Lcom/cineflix/android/TelegramEngine$AuthState$LoggingOut;",
        "Lcom/cineflix/android/TelegramEngine$AuthState$Ready;",
        "Lcom/cineflix/android/TelegramEngine$AuthState$Unknown;",
        "Lcom/cineflix/android/TelegramEngine$AuthState$WaitCode;",
        "Lcom/cineflix/android/TelegramEngine$AuthState$WaitPassword;",
        "Lcom/cineflix/android/TelegramEngine$AuthState$WaitPhone;",
        "app_debug"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final $stable:I


# direct methods
.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    invoke-direct {p0}, Lcom/cineflix/android/TelegramEngine$AuthState;-><init>()V

    return-void
.end method
